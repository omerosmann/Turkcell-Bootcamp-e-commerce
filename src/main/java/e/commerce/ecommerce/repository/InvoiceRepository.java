package e.commerce.ecommerce.repository;

import e.commerce.ecommerce.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {}