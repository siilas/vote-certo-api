package io.github.siilas.votecerto.exception

class CandidateNotFoundException(id: String) : RuntimeException("Candidate $id not found")