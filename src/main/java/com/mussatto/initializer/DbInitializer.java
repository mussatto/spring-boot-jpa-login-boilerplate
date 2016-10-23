package com.mussatto.initializer;

import com.mussatto.model.User;
import com.mussatto.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DbInitializer implements InitializingBean {

    private final DataSource dataSource;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DbInitializer(DataSource dataSource, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.dataSource = dataSource;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ClassPathResource resource = new ClassPathResource("org/springframework/social/connect/jdbc/JdbcUsersConnectionRepository.sql");
        runScript(resource);

        User user = new User();
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("password"));
        userRepository.save(user);
    }

    private void runScript(Resource resource) {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.setContinueOnError(true);
        populator.addScript(resource);
        DatabasePopulatorUtils.execute(populator, dataSource);
    }
}
