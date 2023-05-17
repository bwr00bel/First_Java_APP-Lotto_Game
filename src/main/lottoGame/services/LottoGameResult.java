package services;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class LottoGameResult {

    private String text;

    @Override
    public String toString() {
        return text;
    }
}

