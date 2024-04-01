package org.telegram.telegrambots.meta.api.objects.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.telegram.telegrambots.meta.api.interfaces.BotApiObject;
import org.telegram.telegrambots.meta.api.interfaces.Validable;
import org.telegram.telegrambots.meta.exceptions.TelegramApiValidationException;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * This object represents a portion of goods price.
 */
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@SuperBuilder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class LabeledPrice implements Validable, BotApiObject {
    private static final String LABEL_FIELD = "label";
    private static final String AMOUNT_FIELD = "amount";

    @JsonProperty(LABEL_FIELD)
    @NonNull
    private String label; ///< Portion label
    /**
     * Price of the product in the smallest units of the currency (integer, not float/double).
     * For example, for a price of US$ 1.45 pass amount = 145.
     */
    @JsonProperty(AMOUNT_FIELD)
    @NonNull
    private Integer amount;

    @Override
    public void validate() throws TelegramApiValidationException {
        if (label == null || label.isEmpty()) {
            throw new TelegramApiValidationException("Label parameter can't be empty", this);
        }
        if (amount == null) {
            throw new TelegramApiValidationException("Amount parameter can't be empty", this);
        }
    }
}
