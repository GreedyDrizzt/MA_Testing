package com.yuhong.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yuhong.model.Toy;
import com.yuhong.service.ToyService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.yuhong.model.Orders;
import com.yuhong.service.OrdersService;

@Controller
public class OrdersController {

    private static final Logger logger = Logger
            .getLogger(OrdersController.class);

    public OrdersController() {
        System.out.println("OrdersController()");
    }

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ToyService toyService;

    @RequestMapping(value = {"", "/", "home"})
    public ModelAndView listOrders(ModelAndView model) throws IOException {
        List<Toy> listToy = toyService.getAllToys();
        List<Orders> listOrders = ordersService.getAllOrders();
        model.addObject("listOrders", listOrders);
        model.addObject("listToy", listToy);
        HashMap<String, String> myMap = new HashMap<String, String>();
        for (Toy toy : listToy){
            myMap.put(toy.getGenre(), toy.getTitle());
        }
        model.addObject("myMap", myMap);
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/newOrders", method = RequestMethod.GET)
    public ModelAndView newOrders(ModelAndView model) {
        Orders orders = new Orders();
        List<Toy> toys = toyService.getAllToys();
        model.addObject("Orders", orders);
        model.addObject("toys", toys);
        model.setViewName("Order-form");
        return model;
    }

    @RequestMapping(value = "/newToy", method = RequestMethod.GET)
    public ModelAndView newCToy(ModelAndView model) {
        Toy movi = new Toy();
        model.addObject("Toy", movi);
        model.setViewName("Toy-form");
        return model;
    }

    @RequestMapping(value = "/saveOrders", method = RequestMethod.POST)
    public ModelAndView saveOrders(@ModelAttribute Orders orders) {
        if (orders.getId() == 0) { // if Order id is 0 then creating the
            // Order other updating the Order
            ordersService.addOrders(orders);
        } else {
            ordersService.updateOrders(orders);
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/saveToy", method = RequestMethod.POST)
    public ModelAndView saveToy(@ModelAttribute Toy toy) {
        if (toy.getId() == 0) { // if Toy id is 0 then creating the
            // Toy other updating the Toy
            toyService.addToy(toy);
        } else {
            toyService.updateToy(toy);
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteOrders", method = RequestMethod.GET)
    public ModelAndView deleteOrders(HttpServletRequest request) {
        int OrdersId = Integer.parseInt(request.getParameter("id"));
        ordersService.deleteOrders(OrdersId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/editOrders", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int OrdersId = Integer.parseInt(request.getParameter("id"));
        Orders orders = ordersService.getOrders(OrdersId);
        List<Toy> toys = toyService.getAllToys();
        ModelAndView model = new ModelAndView("Order-form");
        model.addObject("Orders", orders);
        model.addObject("toys", toys);
        return model;
    }

    @RequestMapping(value = "/deleteToy", method = RequestMethod.GET)
    public ModelAndView deleteToy(HttpServletRequest request) {
        int ToyId = Integer.parseInt(request.getParameter("id"));
        toyService.deleteToy(ToyId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/editToy", method = RequestMethod.GET)
    public ModelAndView editToy(HttpServletRequest request) {
        int ToyId = Integer.parseInt(request.getParameter("id"));
        Toy movi = toyService.getToy(ToyId);
        ModelAndView model = new ModelAndView("Toy-form");
        model.addObject("Toy", movi);

        return model;
    }
}