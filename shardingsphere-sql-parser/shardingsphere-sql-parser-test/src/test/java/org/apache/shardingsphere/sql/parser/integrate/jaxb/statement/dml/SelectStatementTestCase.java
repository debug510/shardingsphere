/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.sql.parser.integrate.jaxb.statement.dml;

import lombok.Getter;
import lombok.Setter;
import org.apache.shardingsphere.sql.parser.integrate.jaxb.segment.impl.orderby.ExpectedOrderByClause;
import org.apache.shardingsphere.sql.parser.integrate.jaxb.segment.impl.limit.ExpectedLimitClause;
import org.apache.shardingsphere.sql.parser.integrate.jaxb.segment.impl.predicate.ExpectedWhereClause;
import org.apache.shardingsphere.sql.parser.integrate.jaxb.segment.impl.projection.ExpectedProjections;
import org.apache.shardingsphere.sql.parser.integrate.jaxb.segment.impl.table.ExpectedTable;
import org.apache.shardingsphere.sql.parser.integrate.jaxb.statement.SQLParserTestCase;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.LinkedList;
import java.util.List;

/**
 * Select statement test case.
 * 
 * @author zhangliang 
 */
@Getter
@Setter
public final class SelectStatementTestCase extends SQLParserTestCase {
    
    @XmlElementWrapper
    @XmlElement(name = "table")
    private final List<ExpectedTable> tables = new LinkedList<>();
    
    @XmlElement(name = "projections")
    private final ExpectedProjections projections = new ExpectedProjections();
    
    @XmlElement(name = "where")
    private ExpectedWhereClause whereClause;
    
    @XmlElement(name = "group-by")
    private ExpectedOrderByClause groupByClause;
    
    @XmlElement(name = "order-by")
    private ExpectedOrderByClause orderByClause;
    
    @XmlElement(name = "limit")
    private ExpectedLimitClause limitClause;
    
    @XmlAttribute(name = "lock-clause")
    private boolean lockClause;
}