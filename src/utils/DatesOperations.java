package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Класс операций над датами
 * Created by user on 27.07.2017.
 */

public class DatesOperations {
    public DatesOperations() {
    }

    /**
     * Метод преобразования трех строковых полей в дату
     * @param year - год
     * @param month - месяц
     * @param day - день
     * @return - дату в формате LocalDate
     */
    public LocalDate stringsToDate(String year, String month, String day) {
        return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }

    /**
     * Метод, преобразующий дату в строку
     * @param date - дата
     * @return - строка с разделителями
     */
    public String dateToString(LocalDate date){
        int year =  date.getYear();
        int month = date.getMonthValue();
        return year + ";" + month + ";" +date.getDayOfMonth();
    }

    /**
     * Метод, сравнивающий указанную дату с текущей и возвращающий меньшую
     * @param date - сравниваемая дата
     * @return - результат сравнения в формате LocalDate
     */
    public LocalDate lessSysdate (LocalDate date) {
        LocalDate currentDate = LocalDate.now();
        if (date.compareTo(currentDate) > 0/*date.equals(currentDate)*/) { // если дата превышает текущую дату, присваиваем текущую дату
            date = currentDate;
        }
        return date;
    }

    /**
     * Метод, преобразующий строку в дату формата LocalDateTime
     * @param year - год
     * @param month - месяц
     * @param day - день
     * @return - дата в формате LocalDateTime
     */
    public LocalDateTime stringsToDateTime(String year, String month, String day){
        return LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), 0, 0);
    }

    /**
     * Метод, преобразующий дату формата LocalDateTime в строку
     * @param dateTime - дата
     * @return - строка с разделителями
     */
    public String datetimeToString(LocalDateTime dateTime){
        int year = dateTime.getYear();
        int month = dateTime.getMonthValue();
        return year + ";" + month + ";" +dateTime.getDayOfMonth() + ";" + dateTime.getHour() + ";" + dateTime.getMinute();
    }
}
