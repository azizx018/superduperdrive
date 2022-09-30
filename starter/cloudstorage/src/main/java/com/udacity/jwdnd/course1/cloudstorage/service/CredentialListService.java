package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialListService {
    private  final CredentialMapper credentialMapper;

    public CredentialListService(CredentialMapper credentialMapper) {
        this.credentialMapper = credentialMapper;
    }

    public int updateCred(Credential credential) {
        credential.setCredentialId(credential.getCredentialId());
        credential.setUrl(credential.getUrl());
        credential.setUsername(credential.getUsername());
        credential.setPassword(credential.getPassword());
        return credentialMapper.updateCred(credential);

    }
    public int saveCred(Credential credential, Integer userId) {
        return credentialMapper.saveCred(new Credential(null, credential.getUrl(), credential.getUsername(),
                credential.getPassword(), userId));
    }
    public List<Credential> getCredByUser(Integer userId) {
        return credentialMapper.getCredentialByUser(userId);
    }
    public int deleteCred(Integer credentialId) {
        return credentialMapper.deleteCredByCredId(credentialId);
    }
}
