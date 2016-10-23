package com.mussatto.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SocialSignupController {
    private static final Logger logger = LoggerFactory.getLogger(SocialSignupController.class);
    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    public SocialSignupController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }


    @RequestMapping(value = "/socialsignup", method = RequestMethod.GET)
    public String signup(Model model) {
        System.out.println("/socialsignup");
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            System.out.println("redirecting to connect facebook....");
            return "redirect:/connect/facebook";
        }

        model.addAttribute("facebookProfile", facebook.userOperations().getUserProfile());
        PagedList<Post> feed = facebook.feedOperations().getFeed();
        model.addAttribute("feed", feed);
        return "";
    }
}
