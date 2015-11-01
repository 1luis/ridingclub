package de.nordakademie.iaa.RidingClub.controller;

import de.nordakademie.iaa.RidingClub.model.Member;
import de.nordakademie.iaa.RidingClub.service.MemberService;
import org.springframework.web.bind.annotation.*;
import javax.inject.Inject;
import java.util.List;

@RestController
public class MemberController {

    @Inject
    private MemberService memberService;

    //Aufruf der Mitgliederliste
    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public List<Member> listMembers() {
        return memberService.listMembers();
    }

    //Suche nach Vorname
    @RequestMapping(value = "/searchName/{name}", method = RequestMethod.GET)
    public List<Member> listMembersName(@PathVariable String name) {
        return memberService.listMembersName(name);
    }
    //Suche nach Nachname
    @RequestMapping(value = "/searchSurname/{surname}", method = RequestMethod.GET)
    public List<Member> listMembersSurname(@PathVariable String surname) {
        return memberService.listMembersSurname(surname);
    }
    //Suche nach Vor- und Nachname
    @RequestMapping(value = "/search/{name}/{surname}", method = RequestMethod.GET)
    public List<Member> listMembers(@PathVariable String name, @PathVariable String surname) {
        return memberService.listMembers(name, surname);
    }

    //Löschen eines Mitglieds
    @RequestMapping(value = "/member/{id}", method = RequestMethod.DELETE)
    public void deleteMember(@PathVariable Long id) throws Exception {
        memberService.deleteMember(id);
    }
    //Anlegen und Aktualisieren eines Mitglieds
    @RequestMapping(value = "/member" , method = RequestMethod.PUT)
    public void saveMember(@RequestBody Member member) throws Exception{
        memberService.saveMember(member);
    }



}



