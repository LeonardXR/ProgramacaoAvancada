package com.unicesumar.repository;

import com.unicesumar.entities.Product;
import com.unicesumar.entities.Sales;
import com.unicesumar.entities.User;
import com.unicesumar.paymentMethods.PaymentType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SalesRepository {
    private final Connection connection;

    public SalesRepository(Connection connection) {
        this.connection = connection;
    }

    // -- Operação: inserção nas tabelas sales e sale_products
    public void save(Sales sale) {
        try {
            String insertSaleSQL = "INSERT INTO sales (id, user_id, payment_method, total_value, auth_code, sale_date) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertSaleSQL);
            stmt.setString(1, sale.getId().toString());
            stmt.setString(2, sale.getBuyer().getUuid().toString());
            stmt.setString(3, sale.getPaymentMethod().toString());
            stmt.setDouble(4, sale.getTotalValue());
            stmt.setString(5, sale.getAuthCode());
            stmt.setString(6, sale.getSaleDate().toString());
            stmt.executeUpdate();

            String insertSaleProductSQL = "INSERT INTO sale_products (sale_id, product_id) VALUES (?, ?)";
            for (Product product : sale.getProducts()) {
                PreparedStatement stmtProduct = connection.prepareStatement(insertSaleProductSQL);
                stmtProduct.setString(1, sale.getId().toString());
                stmtProduct.setString(2, product.getUuid().toString());
                stmtProduct.executeUpdate();
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a venda: " + e.getMessage(), e);
        }
    }

    // -- Operação: buscar todas as vendas e os produtos relacionados
    public List<Sales> findAll() {
        List<Sales> salesList = new ArrayList<>();
        String query = "SELECT * FROM sales";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();

            UserRepository userRepository = new UserRepository(connection);
            ProductRepository productRepository = new ProductRepository(connection);

            while (resultSet.next()) {
                UUID saleId = UUID.fromString(resultSet.getString("id"));
                UUID userId = UUID.fromString(resultSet.getString("user_id"));

                Optional<User> buyerOpt = userRepository.findById(userId);
                if (!buyerOpt.isPresent()) continue;

                double totalValue = resultSet.getDouble("total_value");
                PaymentType paymentType = PaymentType.valueOf(resultSet.getString("payment_method"));
                String authCode = resultSet.getString("auth_code");
                LocalDateTime saleDate = LocalDateTime.parse(resultSet.getString("sale_date"));

                List<Product> products = new ArrayList<>();
                String productQuery = "SELECT product_id FROM sale_products WHERE sale_id = ?";
                PreparedStatement productStmt = connection.prepareStatement(productQuery);
                productStmt.setString(1, saleId.toString());
                ResultSet productRs = productStmt.executeQuery();
                while (productRs.next()) {
                    UUID productId = UUID.fromString(productRs.getString("product_id"));
                    productRepository.findById(productId).ifPresent(products::add);
                }

                Sales sales = new Sales(
                        saleId,
                        buyerOpt.get(),
                        products,
                        totalValue,
                        paymentType,
                        authCode,
                        saleDate
                );

                salesList.add(sales);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao recuperar vendas: " + e.getMessage(), e);
        }

        return salesList;
    }
}