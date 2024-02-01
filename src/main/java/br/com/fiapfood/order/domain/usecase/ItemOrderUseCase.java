package br.com.fiapfood.order.domain.usecase;

import br.com.fiapfood.order.domain.model.ItemOrder;

import java.util.UUID;

public interface ItemOrderUseCase {

    public ItemOrder findById(UUID id);

    ItemOrder createItemOrdem(ItemOrder itemOrder);

    void deleteByOrderId(Long id);

    ItemOrder update(ItemOrder itemOrder);
}
