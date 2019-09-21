package com.upgrad.technical.api.thoughtSpotTest;

import java.util.ArrayList;
import java.util.List;

/*
{
  "checkedAnswers": [
    "\"a\"",
    "\"b\"",
    "\"c\""
  ],
  "failedAnswers": [
    "\"c\""
  ]
}
*/

public class Main {

    // 1) Create Request input models
    // Parse JSON
    // verification

    public Main() {
    }

    public static void main(String[] args) {
        String v0 = "{\"checkedAnswers\":[\"a\",\"b\",\"c\"],\"failedAnswers\":[\"c\"]}";
        String v1 = "{\"checkedAnswers\":[\"a\",\"b\",\"c\"],\"failedAnswers\":[\"d\"]}";
        System.out.println(validate(v0, v1));
    }

    public static boolean validate(String v0, String v1) {
        List<ArrayList<String>> version0Lst = parse(v0);
        List<ArrayList<String>> version1Lst = parse(v1);
        return validatePrcessed(version0Lst.get(0), version1Lst.get(0)) && validateFailed(version0Lst.get(1), version1Lst.get(1));
    }

    public static boolean validateFailed(ArrayList<String> version0Lst, ArrayList<String> version1Lst) {
        if (version1Lst.size() > version0Lst.size()) {
            //Log.error("version 1 list size should be greater ");
            return false;
        }
        for (String check : version1Lst) {
            if (version0Lst.contains(check)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean validatePrcessed(ArrayList<String> version0Lst, ArrayList<String> version1Lst) {
        if (version1Lst.size() < version0Lst.size()) {
            //Log.error("version 1 list size should be greater ");
            return false;
        }
        for (String check : version0Lst) {
            if (version1Lst.contains(check)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static List<ArrayList<String>> parse(String input) {
        int startChecked = input.indexOf("[");
        int endChecked = input.indexOf("]");

        String inputCheckedSubString = input.substring(startChecked + 1, endChecked);
        System.out.println(inputCheckedSubString);

        int startfinished = input.lastIndexOf("[");
        int endfinished = input.lastIndexOf("]");
        String finishedCheckedSubString = input.substring(startfinished + 1, endfinished);

        ArrayList<String> checked = addtoList(inputCheckedSubString);
        ArrayList<String> failed = addtoList(finishedCheckedSubString);

        List<ArrayList<String>> finalList = new ArrayList<>();
        finalList.add(checked);
        finalList.add(failed);
        return finalList;
    }

    public static ArrayList<String> addtoList(String input) {
        ArrayList<String> checked = new ArrayList<>();
        String[] checkedElements = input.split(",");
        for (String s : checkedElements) {
            checked.add(s.substring(1, s.length() - 1));
        }
        return checked;
    }
}




