/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ajoberstar.grgit.service

import org.ajoberstar.grgit.Commit
import org.ajoberstar.grgit.Repository
import org.ajoberstar.grgit.operation.CommitOp
import org.ajoberstar.grgit.operation.LogOp
import org.ajoberstar.grgit.operation.RevertOp
import org.ajoberstar.grgit.util.ConfigureUtil

class HistoryService {
	private final Repository repository

	HistoryService(Repository repository) {
		this.repository = repository
	}

	// List<DiffEntry> diff(Map parms)

	List<Commit> log(Map parms = [:]) {
		LogOp log = new LogOp(repository)
		ConfigureUtil.configure(log, parms)
		return log.call()
	}

	List<Commit> log(Closure config) {
		LogOp log = new LogOp(repository)
		ConfigureUtil.configure(log, config)
		return log.call()
	}

	// List<RefLogEntry> reflog(Map parms)
	// BlameResult blame(Map parms)

	Commit commit(Map parms = [:]) {
		CommitOp commit = new CommitOp(repository)
		ConfigureUtil.configure(commit, parms)
		return commit.call()
	}

	Commit commit(Closure config) {
		CommitOp commit = new CommitOp(repository)
		ConfigureUtil.configure(commit, config)
		return commit.call()
	}

	Commit revert(Map parms = [:]) {
		RevertOp revert = new RevertOp(repository)
		ConfigureUtil.configure(revert, parms)
		return revert.call()
	}

	Commit revert(Closure config) {
		RevertOp revert = new RevertOp(repository)
		ConfigureUtil.configure(revert, config)
		return revert.call()
	}

	void cherryPick(Map parms) {

	}

	void merge(Map parms) {

	}

	void rebase(Map parms) {

	}
}
