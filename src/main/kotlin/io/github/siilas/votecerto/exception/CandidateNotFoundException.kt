package io.github.siilas.votecerto.exception

class CandidateNotFoundException(id: Int) : RuntimeException("Candidate $id not found")
