package de.nordakademie.iaa.RidingClub.controller;

import de.nordakademie.iaa.RidingClub.model.Member;
import de.nordakademie.iaa.RidingClub.service.MemberService;
import org.springframework.web.bind.annotation.*;
import javax.inject.Inject;
import java.util.List;

@RestController
public class MemberController {

    private MemberService memberService;

    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public List<Member> listMembers() {
        return memberService.listMembers();
    }

    @RequestMapping(value = "/members", method = RequestMethod.PUT)
    public void saveRoom(@RequestBody Member member) throws Exception {
        memberService.saveMember(member);
    }

    @RequestMapping(value = "/member/{id}", method = RequestMethod.DELETE)
    public void deleteMember(@PathVariable Long id) throws Exception {
        memberService.deleteMember(id);
    }

    @Inject
    public void setRoomService(MemberService memberService) {
        this.memberService = memberService;
    }
}



