/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package req.backing;

import java.time.LocalDate;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;
import javax.validation.constraints.Size;

import req.facade.RequestsFacadeLocal;
import req.entities.Requests;

/**
 *
 * @author wojtek
 */
@Named(value = "requestsList")
@RequestScoped
public class RequestsList {

    @Inject
    private RequestsFacadeLocal requestFacade;

    /**
     * Creates a new instance of RequestsList
     */
    public RequestsList() {
    }

    public List<Requests> getAllRequests() {
        return this.requestFacade.findAll();
    }

    @Size(min=3, max=60, message="{request.size}")
    private String newRequest;

    /**
     * Get the value of newRequest
     *
     * @return the value of newRequest
     */
    public String getNewRequest() {
        return newRequest;
    }

    /**
     * Set the value of newRequest
     *
     * @param newRequest new value of newRequest
     */
    public void setNewRequest(String newRequest) {
        this.newRequest = newRequest;
    }

    private HtmlDataTable requestsDataTable;

    /**
     * Get the value of requestsDataTable
     *
     * @return the value of requestsDataTable
     */
    public HtmlDataTable getRequestsDataTable() {
        return requestsDataTable;
    }

    /**
     * Set the value of requestsDataTable
     *
     * @param requestsDataTable new value of requestsDataTable
     */
    public void setRequestsDataTable(HtmlDataTable requestsDataTable) {
        this.requestsDataTable = requestsDataTable;
    }

    public String addRequest() {
        Requests req = new Requests();
        req.setRequestText(this.getNewRequest());
        req.setRequestDate(LocalDate.now());

        this.requestFacade.create(req);
        setNewRequest("");
        return null;
    }

    public String deleteRequest() {
        Requests req = (Requests) getRequestsDataTable().getRowData();
        this.requestFacade.remove(req);
        return null;
    }

}
