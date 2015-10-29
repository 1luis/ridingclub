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

    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public List<Member> listMembers() {
        return memberService.listMembers();
    }

    @RequestMapping(value = "/member/{name}/{surname}", method = RequestMethod.GET)
    public List<Member> listMembers(@PathVariable String name, @PathVariable String surname) {
        return memberService.listMembers(name, surname);
    }


    @RequestMapping(value = "/member/{id}", method = RequestMethod.DELETE)
    public void deleteMember(@PathVariable Long id) throws Exception {
        memberService.deleteMember(id);
    }

    @RequestMapping(value = "/member" , method = RequestMethod.PUT)
    public void saveMember(@RequestBody Member member) throws Exception{
        memberService.saveMember(member);
    }
    //TODO SearchMemberRequest implementieren
    /*
    @RequestMapping(value = "/searchMember", method = RequestMethod.GET)
    public List<Member> searchMember(@RequestBody SearchMemberRequest reqSeach) {
        return memberService.searchMember(reqSeach);
    }
*/


}



