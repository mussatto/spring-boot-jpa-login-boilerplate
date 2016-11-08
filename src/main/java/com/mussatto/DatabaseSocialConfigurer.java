package com.mussatto;

import com.mussatto.repository.MyJdbcUsersConnectionRepository;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;

import javax.sql.DataSource;

public class DatabaseSocialConfigurer extends SocialConfigurerAdapter {
    private final DataSource dataSource;

    public DatabaseSocialConfigurer(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        TextEncryptor textEncryptor = Encryptors.noOpText();
        return new MyJdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, textEncryptor);
    }
}