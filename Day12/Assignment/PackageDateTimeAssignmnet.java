package day12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class PackageDateTimeAssignmnet {
public static void main(String[] args) {
	//PackageDeliveryDetails pdd = new PackageDeliveryDetails(LocalDateTime.now());
	System.out.println(LocalDateTime.now());
	Delivery d = new DeliveryByTransport(100000, 10, 6, new PackageDeliveryDetails(LocalDateTime.now()));
	System.out.println(d.getDeliveryDateandTime());
	
}
}

interface Delivery{
	public LocalDateTime getDeliveryDateandTime();
}

class PackageDeliveryDetails{
	private LocalDateTime packDateTime;
	private LocalDateTime deliveryDateTime;
	
	private LocalDate packDate;
	private LocalTime packTime;
	
	private LocalDate deliveryDate;
	private LocalTime deliveryTime;
	
	public PackageDeliveryDetails(LocalDateTime packDateTime) {
		// TODO Auto-generated constructor stub
		this.packDateTime = packDateTime;
		this.packDate = packDateTime.toLocalDate();
		this.packTime = packDateTime.toLocalTime();
		System.out.println(packTime);
	}
	
	public LocalTime getPackTime() {
		return packTime;
	}
	public LocalDateTime getPackDateTime() {
		return packDateTime;
	}
	
	public LocalDateTime getDeliveryDateTime() {
		return deliveryDateTime;
	}
	
	public void setDeliveryDateTime(LocalDateTime deliveryDateTime) {
		this.deliveryDateTime = deliveryDateTime;
	}


	public LocalDate getPackDate() {
		return packDate;
	}

	public LocalTime getDeliveryTime() {
		return deliveryTime;
	}


	public void setDeliveryTime(LocalTime deliveryTime) {
		this.deliveryTime = deliveryTime;
	}


	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
		System.out.println(deliveryDate + " is the delivery dtae");
	}
	
}
enum Holidays{
	
	//M01D01, M01D26, M08D15, M10D02; 
	REPUBLICDAY(26, 1), NEWYEAR(1, 1), INDEPENDENCEDAY(15, 8), GANDHIJAYANTHI(2, 10);
	int date;
	int month;
	int daysAsNumbers;
	
	Holidays(int date, int month){
		this.date = date;
		this.month = month;
		daysAsNumbers = DateCalculationsForDelivery.findDaysinMonth(month - 1, 0)*date + date;	
	}
}


class DateCalculationsForDelivery{
	
	public static int findDaysinMonth(int month, int year) {
		
	switch(month) {
	case 0:
		return 0;
	case 1:
		return 31;
	case 2:
		if(year%4 == 0)
			return 29;
		return 28;
	case 3:
		return 31;
	case 4:
		return 30;
	case 5:
		return 31;
	case 6:
		return 30;
	case 7:
		return 31;
	case 8:
		return 31;
	case 9:
		return 30;
	case 10:
		return 31;
	case 11:
		return 30;
	case 12:
		return 31;
	}
	return 0;
	}

	public static int changeDateToNumber(LocalDate date) {
		int month = date.getMonthValue();
		int day = date.getDayOfMonth();
		
		return day + findDaysinMonth(month - 1 , day)*day;
	}
	
	public static long findHolidaysInBetween(PackageDeliveryDetails packageDeliveryDetails) {
		long holidayCount = 0;
		
		
		LocalDate packageDate = packageDeliveryDetails.getPackDate();
		LocalDate deliveryDate = packageDeliveryDetails.getDeliveryDate();
		
		int packageDateAsDayNumbers = changeDateToNumber(packageDate);
		int deliveryDateAsDayNumbers = changeDateToNumber(deliveryDate);
		
		Holidays hh[] = Holidays.values();
		for(Holidays holiday : hh) {
		if( (packageDateAsDayNumbers - holiday.daysAsNumbers)*(deliveryDateAsDayNumbers - holiday.daysAsNumbers) < 0)
			holidayCount++;
		}
		System.out.println("Holidays count in between "  + holidayCount);
		return holidayCount;
	}
	
	public static long findDaysToAdd(long totalTimeForTransport, int workingHoursPerDay) {
		return totalTimeForTransport/workingHoursPerDay;
	}
	
	public static long findTimeToAdd(long totalTimeForTransport, int workingHoursPerDay) {
		return totalTimeForTransport%workingHoursPerDay;
	}
	
	public static void addDateandTime(PackageDeliveryDetails packageDeliveryDetials, long timeToAdd, long dayToAdd) {
		
		System.out.println("Time to add " + timeToAdd + " date to add " + dayToAdd);
		
		packageDeliveryDetials.setDeliveryDate(packageDeliveryDetials.getPackDate().plusDays(dayToAdd));
		
		packageDeliveryDetials.setDeliveryDate(packageDeliveryDetials.getDeliveryDate().plusDays(findHolidaysInBetween(packageDeliveryDetials)));
		packageDeliveryDetials.setDeliveryTime(packageDeliveryDetials.getPackTime().plusHours(timeToAdd));
		
		packageDeliveryDetials.setDeliveryDateTime(LocalDateTime.of(packageDeliveryDetials.getDeliveryDate(),packageDeliveryDetials.getDeliveryTime()));
	}
}

class DeliveryByTransport implements Delivery{

	private int workingHoursPerDay;
	private PackageDeliveryDetails packageDeliveryDetials;
	
	private long totalTimeForTransport;
	private long timeToAdd = 0;
	private long daysToAdd = 0;
	
	public DeliveryByTransport(long distance, long speedInKmPerHr, int workingHoursPerDay, PackageDeliveryDetails packageDeliveryDetails) {
		// TODO Auto-generated constructor stub
		
		this.workingHoursPerDay = workingHoursPerDay;
		this.packageDeliveryDetials = packageDeliveryDetails;
		this.totalTimeForTransport = distance/speedInKmPerHr;
	}

	@Override
	public LocalDateTime getDeliveryDateandTime() {
		// TODO Auto-generated method stub
		
		daysToAdd = DateCalculationsForDelivery.findDaysToAdd(totalTimeForTransport, workingHoursPerDay);
		timeToAdd = DateCalculationsForDelivery.findTimeToAdd(totalTimeForTransport, workingHoursPerDay);		
		
		DateCalculationsForDelivery.addDateandTime(packageDeliveryDetials, timeToAdd, daysToAdd);
		
		return packageDeliveryDetials.getDeliveryDateTime();
	}
	
}