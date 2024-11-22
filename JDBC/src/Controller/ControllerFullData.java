package Controller;

import Model.FullData;

import java.util.ArrayList;

public class ControllerFullData {
    private static ArrayList<FullData> viewdata = new ArrayList<>();

    public static ArrayList<FullData> fullData() {
        ControllerDBFilms.getDBMain().getfActors().forEach(fa -> {
            ControllerDBFilms.getDBMain().getfGenres().forEach(fg -> {
                if (fg.getIdFilm() == fa.getIdFilms()) {
                    ControllerDBFilms.getDBMain().getfDirectors().forEach(fd -> {
                        if (fd.getIdFilm() == fa.getIdFilms()) {
                            viewdata.add(new FullData(
                                    ControllerDBFilms.getActor(fa.getIdActor() - 1).getName()
                                    , ControllerDBFilms.getActor(fa.getIdActor() - 1).getBirthday()
                                    , ControllerDBFilms.getDirector(fd.getIdDirector() - 1).getName()
                                    , ControllerDBFilms.getDirector(fd.getIdDirector() - 1).getBirthday()
                                    , ControllerDBFilms.getFilm(fa.getIdFilms() - 1).getTitle()
                                    , ControllerDBFilms.getFilm(fa.getIdFilms() - 1).getYear()
                                    , ControllerDBFilms.getGenre(fg.getIdGenre() - 1).getGenre()
                                    , ControllerDBFilms.getDetail(fa.getIdFilms() - 1).getDuration()
                                    , ControllerDBFilms.getDetail(fa.getIdFilms() - 1).getSynopsis()
                            ));
                        }
                    });
                }
            });
        });
        return viewdata;
    }

    public static void showViewData() {
        viewdata.forEach(fullData -> {
            System.out.println(fullData.toString());
        });
    }
}
