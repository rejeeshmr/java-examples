/*
 * Copyright 2017 MD Sayem Ahmed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codesod.example.validation.rule;

import com.codesod.example.validation.OrderDTO.OrderItem;

import java.math.BigDecimal;
import java.util.Optional;

class PriceValidator implements OrderItemValidator {

  @Override
  public void validate(OrderItem orderItem) {
    String price = Optional.ofNullable(orderItem)
        .map(OrderItem::getPrice)
        .map(String::trim)
        .filter(itemPrice -> !itemPrice.isEmpty())
        .orElseThrow(() -> new IllegalArgumentException("Price cannot be empty."));

    try {
      new BigDecimal(price);
    } catch (NumberFormatException ex) {
      throw new IllegalArgumentException("Given price [" + price + "] is not in valid format", ex);
    }
  }
}
