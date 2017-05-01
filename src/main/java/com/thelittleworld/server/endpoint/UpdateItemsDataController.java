package com.thelittleworld.server.endpoint;

import com.thelittleworld.dao.ItemDAO;
import com.thelittleworld.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UpdateItemsDataController {

    @Autowired
    private ItemDAO itemDAO;

    @RequestMapping(value = "/update_items", method = RequestMethod.GET)
    public ItemUpdateTO updateUserData() {

        return new ItemUpdateTO(itemDAO.getAllItems());
    }

    public class ItemUpdateTO {

        public Collection items;

        ItemUpdateTO(Collection<Item> items) {
            this.items = items;
        }
    }

}
