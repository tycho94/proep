/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import database.Database;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    Database db = new Database();
    

    @GET
    @Path("{id}")
    public Response getOrderByID(@PathParam("id") int id) {
        try {
            r = null;
            Order o = db.getOrderByID(id);
            if (o != null) {
                r = Response.ok(o).build();
            } else {
                r = Response.status(Response.Status.NOT_FOUND)
                        .entity("Order does not exist")
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
/*
    @POST
    @Path("create")
    public Response createOrder(Order o) {
        r = null;
        try {
            if (service.createOrder(o)) {
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
    public Response updateOrder(Order o) {
        r = null;
        try {
            if (service.updateOrder(o)) {
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
            if (service.AddItemToOrder(new Order(), u)) {
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
    }*/

}
