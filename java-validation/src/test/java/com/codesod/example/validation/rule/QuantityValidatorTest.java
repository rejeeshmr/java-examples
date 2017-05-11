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

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import com.codesod.example.validation.OrderDTO.OrderItem;

import org.junit.Test;

public class QuantityValidatorTest {

  @Test
  public void validate_quantityIsNull_invalid() {
    QuantityValidator validator = new QuantityValidator();

    assertThatIllegalArgumentException()
        .isThrownBy(() -> validator.validate(new OrderItem()));
  }

  @Test
  public void validate_quantityIsZero_invalid() {
    OrderItem orderItem = new OrderItem();
    orderItem.setQuantity(0);

    QuantityValidator validator = new QuantityValidator();

    assertThatIllegalArgumentException()
        .isThrownBy(() -> validator.validate(orderItem));
  }

  @Test
  public void validate_quantityNegative_invalid() {
    OrderItem orderItem = new OrderItem();
    orderItem.setQuantity(-1);

    QuantityValidator validator = new QuantityValidator();

    assertThatIllegalArgumentException()
        .isThrownBy(() -> validator.validate(orderItem));
  }

  @Test
  public void validate_quantityValid_validated() {
    OrderItem orderItem = new OrderItem();
    orderItem.setQuantity(5);

    QuantityValidator validator = new QuantityValidator();

    validator.validate(orderItem);
  }
}