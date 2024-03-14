package com.chadium.chadiumapi.controllers;

import com.chadium.chadiumapi.enteties.Community;
import com.chadium.chadiumapi.services.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/communities")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @PostMapping
    public Community createCommunity(@RequestBody Community community) {
        return communityService.createCommunity(community);
    }

    @GetMapping("/{communityId}")
    public ResponseEntity<Community> getCommunityById(@PathVariable int communityId) {
        Community community = communityService.getCommunityById(communityId)
                .orElseThrow(() -> new RuntimeException("Community not found for this id :: " + communityId));
        return ResponseEntity.ok().body(community);
    }

    @PutMapping("/{communityId}")
    public ResponseEntity<Community> updateCommunity(@PathVariable int communityId, @RequestBody Community communityDetails) {
        Community updatedCommunity = communityService.updateCommunity(communityId, communityDetails);
        return ResponseEntity.ok(updatedCommunity);
    }

    @DeleteMapping("/{communityId}")
    public ResponseEntity<?> deleteCommunity(@PathVariable int communityId) {
        communityService.deleteCommunity(communityId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Community> getAllCommunities() {
        return communityService.getAllCommunities();
    }
}
