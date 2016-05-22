/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.User;
import model.Item;
import model.Order;
import service.OrderService;

/**
 *
 * @author Amir
 */

@Path("order")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {
   
    Response r;
    OrderService service;

    public OrderResource() {
        service = new OrderService();
    }

    @GET
    @Path("owner/{username}")
    public Response getOrderByName(@PathParam("username") String username) {
        try {
            r = null;
            User u = service.getOrderByName(username);
            if (u != null) {
                r = Response.ok(u).build();
            } else {
                r = Response.status(Response.Status.NOT_FOUND)
                        .entity("User does not exist")
                        .build();
            }
        } catch (Exception e) {
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }

    @POST
    @Path("create")
    public Response createOrder(Order u) {
        r = null;
        try {
            if (service.createOrder(u)) {
                r = Response.ok().build();
            } else {
                r = Response.status(Response.Status.CONFLICT)
                        .entity("Order already exists")
                        .build();
            }
        } catch (Exception e) {
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }

    @PUT
    @Path("update")
    public Response updateOrder(Order u) {
        r = null;
        try {
            if (service.updateOrder(u)) {
                r = Response.noContent().build();
            } else {
                r = Response.status(Response.Status.NOT_FOUND)
                        .entity("Order not found")
                        .build();
            }
        } catch (Exception e) {
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }

    @POST
    @Path("additem")
    public Response AddItemOrder(Item u) {
        r = null;
        try {
            if (service.AddItemOrder(u)) {
                r = Response.ok().build();
            } else {
                r = Response.status(Response.Status.CONFLICT)
                        .entity("Item already exists")
                        .build();
            }
        } catch (Exception e) {
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }
    
    @POST
    @Path("addorder")
    public Response AddOrder(Order u) {
        r = null;
        try {
            if (service.AddOrder(u)) {
                r = Response.ok().build();
            } else {
                r = Response.status(Response.Status.CONFLICT)
                        .entity("Item already exists")
                        .build();
            }
        } catch (Exception e) {
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }
 
}
