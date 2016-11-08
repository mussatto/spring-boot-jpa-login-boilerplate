package com.mussatto;

import com.mussatto.repository.MyJdbcUsersConnectionRepository;
import com.mussatto.repository.ProfileRepository;
import com.mussatto.repository.UserConnectionRepository;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;

import javax.sql.DataSource;

class DatabaseSocialConfigurer extends SocialConfigurerAdapter {
    private final DataSource dataSource;
    private ProfileRepository profileRepository;
    private UserConnectionRepository userConnectionRepository;

    DatabaseSocialConfigurer(DataSource dataSource, ProfileRepository profileRepository, UserConnectionRepository userConnectionRepository) {
        this.dataSource = dataSource;
        this.profileRepository = profileRepository;
        this.userConnectionRepository = userConnectionRepository;
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        TextEncryptor textEncryptor = Encryptors.noOpText();
        return new MyJdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, textEncryptor, profileRepository, userConnectionRepository);
    }
}