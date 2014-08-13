package demo;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
     
}

@RestController
class BookingController {
	
	@RequestMapping("bookings")
	Collection<Booking> bookings () {
		return this.bookingRepository.findAll();
	}
	
	@RequestMapping("index")
	ModelAndView index () {
		return new ModelAndView("index");
	}
	
	@RequestMapping("booking/{bookingId}")
	Booking getUser (@PathVariable Long bookingId) {
		return this.bookingRepository.findOne(bookingId);
	}
	
	@Autowired
	private BookingRepository bookingRepository;
}


@Component
class BookingCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
		for (Booking b : bookingRepository.findAll()) {
			System.out.println(b.toString());
		}
		
	}
	
	@Autowired
	private BookingRepository bookingRepository;
	
}

interface BookingRepository extends JpaRepository<Booking, Long> {
	
	Collection<Booking> findByBookingName(final String bookingName);
}

@Entity
class Booking {
	
	@Id @GeneratedValue
	private Long id;
	private String bookingName;
	public Booking(String bookingName) {
		super();
		this.bookingName = bookingName;
	}
	
	public Booking() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBookingName() {
		return bookingName;
	}
	public void setBookingName(String bookingName) {
		this.bookingName = bookingName;
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookingName=" + bookingName + "]";
	}
	
}
