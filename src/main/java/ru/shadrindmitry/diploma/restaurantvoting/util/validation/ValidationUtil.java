package ru.shadrindmitry.diploma.restaurantvoting.util.validation;

import lombok.experimental.UtilityClass;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.lang.NonNull;
import ru.shadrindmitry.diploma.restaurantvoting.HasId;
import ru.shadrindmitry.diploma.restaurantvoting.error.IllegalRequestDataException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

@UtilityClass
public class ValidationUtil {

    public static void checkNew(HasId bean) {
        if (!bean.isNew()) {
            throw new IllegalRequestDataException(bean.getClass().getSimpleName() + " must be new (id=null)");
        }
    }

    //  Conservative when you reply, but accept liberally (http://stackoverflow.com/a/32728226/548473)
    public static void assureIdConsistent(HasId bean, int id) {
        if (bean.isNew()) {
            bean.setId(id);
        } else if (bean.id() != id) {
            throw new IllegalRequestDataException(bean.getClass().getSimpleName() + " must has id=" + id);
        }
    }

    public static void checkModification(int count, int id) {
        if (count == 0) {
            throw new IllegalRequestDataException("Entity with id=" + id + " not found");
        }
    }
    public static <T> T checkExisted(T obj, int id) {
        if (obj == null) {
            throw new IllegalRequestDataException("Entity with id=" + id + " not found");
        }
        return obj;
    }

    //  https://stackoverflow.com/a/65442410/548473
    @NonNull
    public static Throwable getRootCause(@NonNull Throwable t) {
        Throwable rootCause = NestedExceptionUtils.getRootCause(t);
        return rootCause != null ? rootCause : t;
    }

    public static void checkDateAndTimeOfVoting(LocalDate dateVote) {
        Date date = Calendar.getInstance().getTime();
        LocalDate currentDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date));
        LocalTime currentTime = LocalTime.parse(new SimpleDateFormat("HH:mm:ss").format(date));
        LocalTime restrictionOfVotingByTime = LocalTime.parse("11:00"); //remove the crutch

        if (dateVote.compareTo(currentDate)<0
                || (dateVote.compareTo(currentDate)==0
                && currentTime.compareTo(restrictionOfVotingByTime)>0)) {
            throw new IllegalRequestDataException("The voting date must be less than 11.00 of the current date");
        }
    }
}