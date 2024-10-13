package org.nexsys.marketplace.repository;

import org.nexsys.marketplace.entity.ProductoNexsys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<ProductoNexsys, Long> {
}
