package mastersofcode.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static mastersofcode.security.Constants.HEADER_AUTHORIZACION_KEY;
import static mastersofcode.security.Constants.LOGIN_URL;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private UserDetailsService userDetailsService;

	public WebSecurity(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		/*
		 * 1. Se desactiva el uso de cookies
		 * 2. Se activa la configuración CORS con los valores por defecto
		 * 3. Se desactiva el filtro CSRF
		 * 4. Se indica que el login no requiere autenticación
		 * 5. Se indica que el resto de URLs esten securizadas
		 */
		httpSecurity
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.cors().and()
			.csrf().disable()
			.authorizeRequests().antMatchers(HttpMethod.POST, LOGIN_URL).permitAll().and()
			.authorizeRequests().antMatchers(HttpMethod.POST, "/users/").permitAll().and()
			.authorizeRequests().antMatchers(HttpMethod.GET, "/users/").permitAll().and()
			.authorizeRequests().antMatchers(HttpMethod.GET,"/resenas").permitAll().and()
			.authorizeRequests().antMatchers(HttpMethod.GET,"/educacion").permitAll().and()
			.authorizeRequests().antMatchers(HttpMethod.GET,"/experiencia").permitAll().and()
			.authorizeRequests().antMatchers(HttpMethod.GET,"/proyectos").permitAll().and()
			.authorizeRequests().antMatchers(HttpMethod.GET,"/solicitudes").permitAll().and()
			.authorizeRequests().antMatchers(HttpMethod.GET,"/tecnologia").permitAll().and()
			.authorizeRequests().antMatchers(HttpMethod.GET,"/solicitudes/recientes").permitAll().and()
			.authorizeRequests().antMatchers(HttpMethod.GET,"/users/{username}").permitAll().and()
			.authorizeRequests().antMatchers(HttpMethod.GET,"/proyectos/titulo/{titulo}").permitAll().and()
			.authorizeRequests().antMatchers(HttpMethod.GET,"/proyectos/{id}").permitAll()


				.anyRequest().authenticated().and()
				.addFilter(new JWTAuthenticationFilter(authenticationManager()))
				.addFilter(new JWTAuthorizationFilter(authenticationManager()));
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Se define la clase que recupera los usuarios y el algoritmo para procesar las passwords
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*")
						.exposedHeaders(HEADER_AUTHORIZACION_KEY);
			}
		};
	}
}
