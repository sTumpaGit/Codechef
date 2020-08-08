/*

You might have heard about our new goodie distribution program aka the "Laddu Accrual System". This problem is designed to give you a glimpse of its rules. You can read the page once before attempting the problem if you wish, nonetheless we will be providing all the information needed here itself.

Laddu Accrual System is our new goodie distribution program. In this program, we will be distributing Laddus in place of goodies for your winnings and various other activities (described below), that you perform on our system. Once you collect enough number of Laddus, you can then redeem them to get yourself anything from a wide range of CodeChef goodies.

Let us know about various activities and amount of laddus you get corresponding to them.

Contest Win (CodeChef’s Long, Cook-Off, LTIME, or any contest hosted with us) : 300 + Bonus (Bonus = 20 - contest rank). Note that if your rank is > 20, then you won't get any bonus.
Top Contributor on Discuss : 300
Bug Finder : 50 - 1000 (depending on the bug severity). It may also fetch you a CodeChef internship!
Contest Hosting : 50
You can do a checkout for redeeming laddus once a month. The minimum laddus redeemable at Check Out are 200 for Indians and 400 for the rest of the world.

You are given history of various activities of a user. The user has not redeemed any of the its laddus accrued.. Now the user just wants to redeem as less amount of laddus he/she can, so that the laddus can last for as long as possible. Find out for how many maximum number of months he can redeem the laddus.

Input :-
The first line of input contains a single integer T denoting number of test cases
For each test case:
First line contains an integer followed by a string denoting activities, origin respectively, where activities denotes number of activities of the user, origin denotes whether the user is Indian or the rest of the world. origin can be "INDIAN" or "NON_INDIAN".
For each of the next activities lines, each line contains an activity.
An activity can be of four types as defined above.
Contest Win : Input will be of form of CONTEST_WON rank, where rank denotes the rank of the user.
Top Contributor : Input will be of form of TOP_CONTRIBUTOR.
Bug Finder : Input will be of form of BUG_FOUND severity, where severity denotes the severity of the bug.
Contest Hosting : Input will be of form of CONTEST_HOSTED.

Output :-
For each test case, find out the maximum number of months for which the user can redeem the laddus accrued.

Constraints
1 ≤ T, activities ≤ 100
1 ≤ rank ≤ 5000
50 ≤ severity ≤ 1000

Subtasks
There is only a single subtask with 100 points.

Example

Input:
2
4 INDIAN
CONTEST_WON 1
TOP_CONTRIBUTOR
BUG_FOUND 100
CONTEST_HOSTED
4 NON_INDIAN
CONTEST_WON 1
TOP_CONTRIBUTOR
BUG_FOUND 100
CONTEST_HOSTED

Output:
3
1

*/

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	
Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int activityNum = sc.nextInt();
			String origin = sc.next();
			sc.nextLine();
			String[] activities = new String[activityNum];
			for (int i = 0; i < activities.length; i++) {
				activities[i] = sc.nextLine();
			}

			System.out.println(solve(activities, origin));
		}

		sc.close();
  }

	static int solve(String[] activities, String origin) {
		int laddu = 0;
		for (String activity : activities) {
			String[] parts = activity.split(" ");
			if (parts[0].equals("CONTEST_WON")) {
				int rank = Integer.parseInt(parts[1]);

				laddu += 300 + Math.max(0, 20 - rank);
			} else if (parts[0].equals("TOP_CONTRIBUTOR")) {
				laddu += 300;
			} else if (parts[0].equals("BUG_FOUND")) {
				int severity = Integer.parseInt(parts[1]);

				laddu += severity;
			} else if (parts[0].equals("CONTEST_HOSTED")) {
				laddu += 50;
			}
		}
		return laddu / (origin.equals("INDIAN") ? 200 : 400);
	}
  
}
