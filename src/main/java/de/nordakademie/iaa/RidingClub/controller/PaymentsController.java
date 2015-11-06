package de.nordakademie.iaa.RidingClub.controller;

import de.nordakademie.iaa.RidingClub.model.Payments;
import de.nordakademie.iaa.RidingClub.service.PaymentsService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Marc & Luis
 */

@RestController
public class PaymentsController {

    @Inject
    private PaymentsService paymentService;

    @RequestMapping(value = "/payments", method = RequestMethod.GET)
    public List<Payments> listPayments() {
        return paymentService.listPayments();
    }

    @RequestMapping(value = "/payment/changeStatus/{payment_id}", method = RequestMethod.GET)
    public void changeStatusPayment(@PathVariable Long payment_id) throws Exception {
        paymentService.changeStatusPayments(payment_id);
    }

    @RequestMapping(value = "/payments/{member_id}", method = RequestMethod.GET)
    public List<Payments> listPayments(@PathVariable Long member_id) {
        return paymentService.listPayments(member_id);
    }

    @RequestMapping(value = "/payments/{payment_id}", method = RequestMethod.DELETE)
    public void deletePayment(@PathVariable Long payment_id) throws Exception {
        paymentService.deletePayments(payment_id);
    }

    @RequestMapping(value = "/payments" , method = RequestMethod.PUT)
    public void savePayment(@RequestBody Payments payment) throws Exception{
        paymentService.savePayment(payment);
    }

}
