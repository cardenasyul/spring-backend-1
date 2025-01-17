package com.sales.market.controller;

import com.sales.market.dto.ItemInventoryDto;
import com.sales.market.model.ItemInventory;
import com.sales.market.model.User;
import com.sales.market.service.ItemInventoryService;
import com.sales.market.service.GenericService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/iteminventorys")
public class ItemInventoryController extends GenericController<ItemInventory, ItemInventoryDto> {
    private ItemInventoryService service;

    public ItemInventoryController(ItemInventoryService service) {
        this.service = service;
    }

    @Override
    protected GenericService getService() {
        return service;
    }

    @GetMapping("/itemsLower")
    public List<ItemInventoryDto> getItemslowerBoundThreshold(){
        List<ItemInventory> itemInventories = service.getItemsLowerBoundery();
        return new ItemInventoryDto().toListDto(itemInventories, modelMapper);
    }
    @GetMapping("/itemsUpper")
    public List<ItemInventoryDto> getItemsupperBoundThreshold(){
        List<ItemInventory> itemInventories = service.getItemsUpperBoundery();
        return new ItemInventoryDto().toListDto(itemInventories, modelMapper);
    }

}
