package e.commerce.ecommerce.common.constants;

import jakarta.servlet.http.PushBuilder;

public class Messages {

    public static class Category{
        public static final String Exists            = "CATEGORY_ALREADY_EXISTS";
        public static final String NotExists         = "CATEGORY_NOT_EXISTS";
        public static final String NameLength        = "CATEGORY_NAME_CANNOT_BE_LEFT_BLANK";
    }

    public static class Invoice{
        public static final String Exists            = "INVOICE_ALREADY_EXISTS";
        public static final String NotExists         = "INVOICE_NOT_EXISTS";
    }

    public static class Payment{
        public static final String Exists            = "PAYMENT_ALREADY_EXISTS";
        public static final String NotExists         = "PAYMENT_NOT_EXISTS";
        public static final String NotEnough         = "BALANCE_NOT_ENOUGH";
        public static final String NotValid          = "CARD_INFORMATION_FAILED_VERIFY";

    }

    public static class Product{
        public static final String Exists            = "PRODUCT_ALREADY_EXISTS";
        public static final String NotExists         = "PRODUCT_NOT_EXISTS";
        public static final String Price             = "PRODUCT_PRICE_MUST_BE_GREATER_THAN_0";
        public static final String Quantity          = "PRODUCT_QUANTITY_CANNOT_BE_LESS_THAN_0";
        public static final String DescriptionLength = "PRODUCT_DESCRIPTION_MUST_CONTAIN_AT_10_CHARACTERS_AND_AT_MOST_50_CHARACTERS";
    }

    public static class Sale{
        public static final String Exists            = "SALE_ALREADY_EXISTS";
        public static final String NotExists         = "SALE_NOT_EXISTS";
        public static final String NotQuantity       = "PRODUCT_NOT_IN_STOCK";
        public static final String NotActive         = "PRODUCT_NOT_SUITABLE_FOR_SALE";
    }

    public static class Ship{
        public static final String Exists            = "SHIP_ALREADY_EXISTS";
        public static final String NotExists         = "SHIP_NOT_EXISTS";
        public static final String ShipNoLength      = "SHIP_NUMBER_CANNOT_BE_LEFT_BLANK";
    }

}
