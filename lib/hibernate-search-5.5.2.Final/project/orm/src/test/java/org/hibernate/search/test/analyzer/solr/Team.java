/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.test.analyzer.solr;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.lucene.analysis.charfilter.HTMLStripCharFilterFactory;
import org.apache.lucene.analysis.charfilter.MappingCharFilterFactory;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.core.LowerCaseTokenizerFactory;
import org.apache.lucene.analysis.core.StopFilterFactory;
import org.apache.lucene.analysis.en.PorterStemFilterFactory;
import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilterFactory;
import org.apache.lucene.analysis.miscellaneous.LengthFilterFactory;
import org.apache.lucene.analysis.miscellaneous.TrimFilterFactory;
import org.apache.lucene.analysis.miscellaneous.WordDelimiterFilterFactory;
import org.apache.lucene.analysis.pattern.PatternTokenizerFactory;
import org.apache.lucene.analysis.phonetic.PhoneticFilterFactory;
import org.apache.lucene.analysis.shingle.ShingleFilterFactory;
import org.apache.lucene.analysis.snowball.SnowballPorterFilterFactory;
import org.apache.lucene.analysis.standard.StandardFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.apache.lucene.analysis.synonym.SynonymFilterFactory;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.AnalyzerDef;
import org.hibernate.search.annotations.AnalyzerDefs;
import org.hibernate.search.annotations.CharFilterDef;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Parameter;
import org.hibernate.search.annotations.TokenFilterDef;
import org.hibernate.search.annotations.TokenizerDef;

/**
 * @author Emmanuel Bernard
 */
@Entity
@Indexed
@AnalyzerDefs({
		@AnalyzerDef(name = "customanalyzer",
				tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
				filters = {
						@TokenFilterDef(factory = ASCIIFoldingFilterFactory.class),
						@TokenFilterDef(factory = LowerCaseFilterFactory.class),
						@TokenFilterDef(factory = StopFilterFactory.class, params = {
								@Parameter(name = "words",
										value = "org/hibernate/search/test/analyzer/stoplist.properties"),
								@Parameter(name = "ignoreCase", value = "true")
						}),
						@TokenFilterDef(factory = SnowballPorterFilterFactory.class, params = {
								@Parameter(name = "language", value = "English")
						})
				}),

		@AnalyzerDef(name = "pattern_analyzer",
				tokenizer = @TokenizerDef(factory = PatternTokenizerFactory.class, params = {
						@Parameter(name = "pattern", value = ",")
				})),

		@AnalyzerDef(name = "standard_analyzer",
				tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
				filters = {
						@TokenFilterDef(factory = StandardFilterFactory.class)
				}),
		@AnalyzerDef(name = "html_standard_analyzer",
				charFilters = {
						@CharFilterDef(factory = HTMLStripCharFilterFactory.class)
				},
				tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
				filters = {
						@TokenFilterDef(factory = StandardFilterFactory.class)
				}),

		@AnalyzerDef(name = "html_whitespace_analyzer",
				tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
				charFilters = {
						@CharFilterDef(factory = HTMLStripCharFilterFactory.class)
				}),

		@AnalyzerDef(name = "trim_analyzer",
				tokenizer = @TokenizerDef(factory = LowerCaseTokenizerFactory.class),
				filters = {
						@TokenFilterDef(factory = InsertWhitespaceFilterFactory.class),
						@TokenFilterDef(factory = TrimFilterFactory.class)
				}),

		@AnalyzerDef(name = "length_analyzer",
				tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
				filters = {
						@TokenFilterDef(factory = LengthFilterFactory.class, params = {
								@Parameter(name = "min", value = "3"),
								@Parameter(name = "max", value = "5")
						})
				}),

		@AnalyzerDef(name = "porter_analyzer",
				tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
				filters = {
						@TokenFilterDef(factory = PorterStemFilterFactory.class)
				}),

		@AnalyzerDef(name = "word_analyzer",
				charFilters = {
						@CharFilterDef(factory = HTMLStripCharFilterFactory.class)
				},
				tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
				filters = {
						@TokenFilterDef(factory = WordDelimiterFilterFactory.class, params = {
								@Parameter(name = "splitOnCaseChange", value = "1")
						})
				}),

		@AnalyzerDef(name = "synonym_analyzer",
				charFilters = {
						@CharFilterDef(factory = HTMLStripCharFilterFactory.class)
				},
				tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
				filters = {
						@TokenFilterDef(factory = SynonymFilterFactory.class, params = {
								@Parameter(
										name = "synonyms",
										value = "org/hibernate/search/test/analyzer/synonyms.properties"
								),
								@Parameter(name = "expand", value = "false")
						})
				}),

		@AnalyzerDef(name = "shingle_analyzer",
				charFilters = {
						@CharFilterDef(factory = HTMLStripCharFilterFactory.class)
				},
				tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
				filters = {
						@TokenFilterDef(factory = ShingleFilterFactory.class)
				}),

		@AnalyzerDef(name = "phonetic_analyzer",
				tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
				filters = {
						@TokenFilterDef(factory = PhoneticFilterFactory.class, params = {
								@Parameter(name = "encoder", value = "Metaphone"),
								@Parameter(name = "inject", value = "false")
						})
				}),

		@AnalyzerDef(name = "html_char_analyzer",
				charFilters = {
						@CharFilterDef(factory = HTMLStripCharFilterFactory.class)
				},
				tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class)
				),

		@AnalyzerDef(name = "mapping_char_analyzer",
				charFilters = {
						@CharFilterDef(factory = MappingCharFilterFactory.class, params = {
								@Parameter(name = "mapping", value = "org/hibernate/search/test/analyzer/mapping-chars.properties")
						})
				},
				tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class)
		)
})
public class Team {
	@Id
	@DocumentId
	@GeneratedValue
	private Integer id;

	@Field
	private String name;

	@Field
	private String location;

	@Field
	@Analyzer(definition = "customanalyzer")
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
