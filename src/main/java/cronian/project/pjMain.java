package cronian.project;

import cronian.project.DB.pjDAO;
import cronian.project.model.pjJoinUpdate;

import java.util.Scanner;

/**
 * Created by java on 2016-09-19.
 */
public class pjMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(pjDAO.checkemail("1",1));
    }
}