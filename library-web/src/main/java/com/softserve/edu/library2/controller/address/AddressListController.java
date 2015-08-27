package com.softserve.edu.library2.controller.address;

import com.softserve.edu.library2.dao.entities.Address;
import com.softserve.edu.library2.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Dmytro Brylyuk
 */
@Controller
@RequestMapping("/addresses")
public class AddressListController {

    @Autowired
    AddressService addressService;

    @RequestMapping(value = {"/list_addresses"}, method = RequestMethod.GET)
    public String listReaders(ModelMap modelMap) {
        List<Address> addresses = addressService.findAll();
        modelMap.addAttribute("addresses", addresses);
        return "/address/AddressList";
    }

    @RequestMapping(value = {"edit_address"}, method = RequestMethod.GET)
    public String edit (ModelMap modelMap) {
        return "/address/EditAddress";
    }

    @RequestMapping(value = {"/new_address"}, method = RequestMethod.GET)
    public String addAddress(ModelMap modelMap) {
        Address address = new Address();
        modelMap.addAttribute("address", address);
        modelMap.addAttribute("add", false);
        return "/address/CreateAddress";
    }
}
