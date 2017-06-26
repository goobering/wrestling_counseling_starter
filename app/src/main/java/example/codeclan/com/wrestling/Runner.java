package example.codeclan.com.wrestling;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by user on 26/06/2017.
 */

public class Runner
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please select from the following:");
        ArrayList<Subject> subjects = Subject.all();

        int input;

        while(true)
        {
            for(int i = 0; i < subjects.size(); i++)
            {
                System.out.println(String.format("%d: %s", i+1, subjects.get(i).getName()));
            }
            System.out.print("> ");

            String selection = sc.nextLine();

            try
            {
                input = Integer.parseInt(selection);
                break;

            }
            catch(NumberFormatException nfe)
            {
                System.out.println("Invalid input! Please try again.");
                System.out.println();
            }
        }

        Counselor subjectCounselor = Counselor.getCounselorBySubjectId(subjects.get(input - 1).getId());
        System.out.println(subjects.get(input - 1).getDescription());
        System.out.println();
        System.out.println(String.format("Name: %s %s %s", subjectCounselor.getFirstName(), subjectCounselor.getNickName(), subjectCounselor.getLastName()));
        System.out.println(String.format("Member since: %s", subjectCounselor.getMemberSince()));
        System.out.println(String.format("Email: %s", subjectCounselor.getEmail()));
        System.out.println(String.format("Phone: %s", subjectCounselor.getTelephone()));
    }
}
