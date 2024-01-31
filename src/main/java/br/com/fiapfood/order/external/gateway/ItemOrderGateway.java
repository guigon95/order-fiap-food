package br.com.fiapfood.order.external.gateway;

import br.com.fiapfood.order.domain.model.ItemOrder;

import java.util.List;
import java.util.UUID;

public interface ItemOrderGateway {

    ItemOrder findById(UUID id);
    List<ItemOrder> findByOrderId(Long id);
    ItemOrder save(ItemOrder itemOrder);

    void deleteByOrderId(Long id);

    ItemOrder update(ItemOrder itemOrder);

    List<ItemOrder> saveAll(List<ItemOrder> itemOrder);
}
