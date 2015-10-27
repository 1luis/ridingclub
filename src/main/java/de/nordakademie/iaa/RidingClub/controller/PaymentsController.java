package de.nordakademie.iaa.RidingClub.controller;

import de.nordakademie.iaa.RidingClub.model.Payments;
import de.nordakademie.iaa.RidingClub.service.PaymentsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by luisiglesias on 24/10/15.
 */
public class PaymentsController {

    @Inject
    private PaymentsService paymentService;

    @RequestMapping(value = "/payments", method = RequestMethod.GET)
    public List<Payments> listPayments() {
        return paymentService.listPayments();
    }


    @RequestMapping(value = "/payments/{id}", method = RequestMethod.DELETE)
    public void deleteMember(@PathVariable Long id) throws Exception {
        paymentService.deletePayments(id);
    }

    @RequestMapping(value = "/payments" , method = RequestMethod.PUT)
    public void savePayment(@RequestBody Payments payment) throws Exception{
        paymentService.savePayment(payment);
    }

}
