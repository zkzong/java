/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
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
 * </p>
 */

package org.example.sj3.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_order_item")
@Data
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 261534701950670670L;

    @Id
    @Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderItemId;

    @Column(name = "order_id")
    private long orderId;

    @Column(name = "user_id")
    private int userId;

}
