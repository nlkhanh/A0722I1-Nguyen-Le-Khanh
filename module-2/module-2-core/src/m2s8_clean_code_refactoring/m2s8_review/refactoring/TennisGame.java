package m2s8_clean_code_refactoring.m2s8_review.refactoring;

public class TennisGame {

    public static String getScore(String firstPlayerName, String secondPlayerName, int firstPlayerScore, int secondPlayerScore) {
        String score = "";
        int tempScore = 0;
        boolean isEqualScore = (firstPlayerScore == secondPlayerScore);
        if (isEqualScore) {
            switch (firstPlayerScore) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else {
            boolean isAnyScoreEqualOrMoreThanFour = ((firstPlayerScore >= 4) || (secondPlayerScore >= 4));
            if (isAnyScoreEqualOrMoreThanFour) {
                int subtractScore = (firstPlayerScore - secondPlayerScore);
                boolean isFirstPlayerScoreHigherOne = (subtractScore == 1);
                boolean isSecondPlayerScoreHigherOne = (subtractScore == -1);
                boolean isFirstPlayerScoreHigherMoreThanOne = (subtractScore >= 2);
                if (isFirstPlayerScoreHigherOne) score = "Advantage player1";
                else if (isSecondPlayerScoreHigherOne) score = "Advantage player2";
                else if (isFirstPlayerScoreHigherMoreThanOne) score = "Win for player1";
                else score = "Win for player2";
            } else {
                for (int turn = 1; turn <= 2; turn++) {
                    boolean firstTurn = (turn == 1);
                    if (firstTurn) tempScore = firstPlayerScore;
                    else {
                        score += "-";
                        tempScore = secondPlayerScore;
                    }
                    switch (tempScore) {
                        case 0:
                            score += "Love";
                            break;
                        case 1:
                            score += "Fifteen";
                            break;
                        case 2:
                            score += "Thirty";
                            break;
                        case 3:
                            score += "Forty";
                            break;
                    }
                }
            }
        }
        return score;
    }
}
