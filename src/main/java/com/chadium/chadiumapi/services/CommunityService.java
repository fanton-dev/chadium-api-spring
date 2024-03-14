package com.chadium.chadiumapi.services;

import com.chadium.chadiumapi.enteties.Community;
import com.chadium.chadiumapi.repositories.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    public Community createCommunity(Community community) {
        return communityRepository.save(community);
    }

    public Optional<Community> getCommunityById(int id) {
        return communityRepository.findById(id);
    }

    public Community updateCommunity(int id, Community communityDetails) {
        Community community = communityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Community not found for this id :: " + id));
        community.setName(communityDetails.getName());
        community.setDescription(communityDetails.getDescription());
        community.setColor(communityDetails.getColor());
        community.setImageUrl(communityDetails.getImageUrl());
        return communityRepository.save(community);
    }

    public void deleteCommunity(int id) {
        Community community = communityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Community not found for this id :: " + id));
        communityRepository.delete(community);
    }

    public List<Community> getAllCommunities() {
        return communityRepository.findAll();
    }
}
