package com.mussatto.repository;

import com.mussatto.model.Profile;
import com.mussatto.model.UserConnection;
import com.mussatto.model.UserConnectionPK;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.util.MultiValueMap;

import java.util.List;

class ConnectionRepositoryProxy implements ConnectionRepository {

    private MyJdbcConnectionRepository connectionRepository;
    private ProfileRepository profileRepository;
    private UserConnectionRepository userConnectionRepository;

    ConnectionRepositoryProxy(MyJdbcConnectionRepository connectionRepository, ProfileRepository profileRepository, UserConnectionRepository userConnectionRepository) {
        this.connectionRepository = connectionRepository;
        this.profileRepository = profileRepository;
        this.userConnectionRepository = userConnectionRepository;
    }

    @Override
    public MultiValueMap<String, Connection<?>> findAllConnections() {
        return connectionRepository.findAllConnections();
    }

    @Override
    public List<Connection<?>> findConnections(String providerId) {
        return connectionRepository.findConnections(providerId);
    }

    @Override
    public <A> List<Connection<A>> findConnections(Class<A> apiType) {
        return connectionRepository.findConnections(apiType);
    }

    @Override
    public MultiValueMap<String, Connection<?>> findConnectionsToUsers(MultiValueMap<String, String> providerUserIds) {
        return connectionRepository.findConnectionsToUsers(providerUserIds);
    }

    @Override
    public Connection<?> getConnection(ConnectionKey connectionKey) {
        return connectionRepository.getConnection(connectionKey);
    }

    @Override
    public <A> Connection<A> getConnection(Class<A> apiType, String providerUserId) {
        return connectionRepository.getConnection(apiType, providerUserId);
    }

    @Override
    public <A> Connection<A> getPrimaryConnection(Class<A> apiType) {
        return connectionRepository.getPrimaryConnection(apiType);
    }

    @Override
    public <A> Connection<A> findPrimaryConnection(Class<A> apiType) {
        return connectionRepository.findPrimaryConnection(apiType);
    }

    @Override
    public void addConnection(Connection<?> connection) {
        connectionRepository.addConnection(connection);
        ConnectionData data = connection.createData();
        UserConnectionPK pk = new UserConnectionPK(connectionRepository.getUserId(), data.getProviderId(), data.getProviderUserId());
        UserConnection userConnection = userConnectionRepository.findOne(pk);
        Profile profile = new Profile();
        profile.setUserConnection(userConnection);
        profileRepository.save(profile);
    }

    @Override
    public void updateConnection(Connection<?> connection) {
        connectionRepository.updateConnection(connection);

    }

    @Override
    public void removeConnections(String providerId) {
        connectionRepository.removeConnections(providerId);
    }

    @Override
    public void removeConnection(ConnectionKey connectionKey) {
        connectionRepository.removeConnection(connectionKey);
    }
}
