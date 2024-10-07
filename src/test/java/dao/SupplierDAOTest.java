package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.*;

import model.Supplier;
import model.dao.SupplierDAO;
import model.dao.DBConnector;

public class SupplierDAOTest {
    Connection conn;
    SupplierDAO supplierDAO;
    
}
