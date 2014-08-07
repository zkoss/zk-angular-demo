package demo.getting_started.mvvm;

import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import demo.getting_started.tutorial.Car;
import demo.getting_started.tutorial.CarService;
import demo.getting_started.tutorial.CarServiceImpl;

public class SearchViewModel {

	private String keyword;
	private List<Car> carList;
	private Car selectedCar;

	private CarService carService = new CarServiceImpl();

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public List<Car> getCarList() {
		return carList;
	}
	
	@NotifyChange("carList")
	public void setCarList(List<Car>carList) {
		this.carList = carList;
	}

	public void setSelectedCar(Car selectedCar) {
		this.selectedCar = selectedCar;
	}

	public Car getSelectedCar() {
		return selectedCar;
	}

	@Command
	@NotifyChange("carList")
	public void search() {
		carList = carService.search(keyword);
	}
	
	@Command
	@NotifyChange("carList")
	public void update(@BindingParam("car") Car car) {
		int i = 0;
		for (Car c : carService.findAll()) {
			if (c.getId().equals(car.getId())) {
				break;
			}
			i++;
		}
		carService.findAll().set(i, car);
		carList = carService.search(keyword);
	}
	
	@Command
	@NotifyChange({"carList", "keyword"})
	public void resetVM() {
		keyword = null;
		carList = carService.search(keyword);
	}
}
