package com.softserve.edu.library2.controller.address;

import com.softserve.edu.library2.dao.entities.Address;
import com.softserve.edu.library2.dao.entities.Reader;
import com.softserve.edu.library2.service.AddressService;
import com.softserve.edu.library2.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dmytro Brylyuk
 */
@Controller
@RequestMapping("/addresses")
public class AddressListController {

    @Autowired
    AddressService addressService;

    @Autowired
    ReaderService readerService;

    @RequestMapping(value = {"/list_addresses"}, method = RequestMethod.GET)
    public String listAddresses(ModelMap modelMap) {
        List<Address> addresses = addressService.findAll();
        modelMap.addAttribute("addresses", addresses);
        return "/address/AddressList";
    }

    @RequestMapping(value = {"/list_readers_addresses"}, method = RequestMethod.GET)
    public String listReadersAddresses(ModelMap modelMap) {
        List<Address> addresses = addressService.findAll();
        Map<Address, List<Reader>> addressListMap = new HashMap<Address, List<Reader>>();
        for (Address address : addresses) {
            try {
                addressListMap.put(address, readerService.findByAddress(address));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        modelMap.addAttribute("addressListMap", addressListMap);
        return "/address/ReaderAddressList";
    }

    @RequestMapping(value = {"/new_address"}, method = RequestMethod.GET)
    public String newAddress(ModelMap modelMap) {
        Address address = new Address();
        modelMap.addAttribute("address", address);
        modelMap.addAttribute("edit", false);
        return "/address/EditAddress";
    }

    @RequestMapping(value = {"/new_address"}, method = RequestMethod.POST)
    public String saveAddress(@Valid Address address, BindingResult result, ModelMap modelMap) {
        addressService.save(address);
        modelMap.addAttribute("success", "User" + address.getCity() + " " + address.getRegion() + " "
                + address.getStreet() + " " + address.getBuildingNumber() + " " + address.getApartmentNumber() +
                " registered successfully");
        return "redirect:/addresses/list_addresses";
    }

    @RequestMapping(value = {"/edit-address-{id}"}, method = RequestMethod.GET)
    public String editAddress (@PathVariable String id, ModelMap modelMap) {
        Address address = addressService.findById(Integer.valueOf(id));
        modelMap.addAttribute("address", address);
        modelMap.addAttribute("edit", true);
        return "/address/EditAddress";
    }

    @RequestMapping(value = {"/edit-address-{id}"}, method = RequestMethod.POST)
    public String updateAddress(@Valid Address address, BindingResult result, ModelMap modelMap) {
        addressService.save(address);
        modelMap.addAttribute("success", "User" + address.getCity() + " " + address.getRegion() + " "
                + address.getStreet() + " " + address.getBuildingNumber() + " " + address.getApartmentNumber() +
                " update successfully");
        return "redirect:/addresses/list_addresses";
    }

    @RequestMapping(value = {"/delete-address-{id}"}, method = RequestMethod.GET)
    public String deleteAddress(@PathVariable String id) {
        addressService.deleteById(Integer.valueOf(id));
        return "redirect:/addresses/list_addresses";
    }

}
