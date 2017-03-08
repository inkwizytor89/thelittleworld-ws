package com.thelittleworld.server.endpoint;

import com.thelittleworld.dao.ItemDAO;
import com.thelittleworld.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UpdateItemsDataController {

    @Autowired
    private ItemDAO itemDAO;

    @RequestMapping(value = "/update_items", method = RequestMethod.GET)
    public List<Item> updateUserData() {

        return itemDAO.getAllItems();
    }

}
