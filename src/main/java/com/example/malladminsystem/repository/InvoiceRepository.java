package com.example.malladminsystem.repository;

import java.util.*;

import com.example.malladminsystem.model.*;
import org.springframework.data.repository.*;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

    Invoice findByIdInvoice(long id);

    List<Invoice> findAll();

    List<Invoice> findAllByIsPaidIsFalse();
}
