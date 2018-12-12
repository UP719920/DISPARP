#ZERO KNOWLEDGE VOTE VERIFICATION PROTOCOL
#Initial Interactive Version
#UP719920
import time
import random

timeStart = time.time()

#E-voting scheme creates b and sents to Voter and System
b = 10

def verifyVote(x):
    #Protocol checks x belongs to {0, 1}
    if x == 0 or x == 1:
        #Voter uses x to calculate A
        A = b ** x
        #Voter sends A to System

        #Voter selects i randomly and calculates C
        i = random.randint(1, 11)
        C = b ** i
        #Voter sends C to System

        #System selects j randomly and sends it to Voter
        j = random.randint(1, 11)

        #Voter uses j to calculate D
        D = i - (j * x)
        #Voter sends D to System

        #System verifies Voter declaration. First claculates R
        R = int((b ** D) * (A ** j))
        #System checks result R is equal to commitment C
        if R == C:
            #System sends verified vote to next step of E-voting scheme
            return("VOTE VERIFIED: Proceed to next step.")
        else:
            #System discards invalid vote
            return("VOTE NOT VERIFIED: DISCARD VOTE")
    else:
        #E-voting system rejects vot submission
        return("VOTE SELECTION NOT VALID")


#Create set of vote submissions (Voters select x)
testVotes = []
for i in range(33):
    #Adds 0 or 1 for two thirds of the testVotes
    testVotes.append(random.randint(0, 1))
    testVotes.append(random.randint(0, 1))
    #Adds incorrect votes for final third of testVotes
    testVotes.append(random.randint(2, 100))
print(testVotes)

#Keep track of if a vote is counted or not or invalid
verifiedVotes = 0
discardedVotes = 0
invalidVoteSub = 0

for voteSub in testVotes:
    if verifyVote(voteSub) == "VOTE VERIFIED: Proceed to next step.":
        verifiedVotes += 1
    elif verifyVote(voteSub) == "VOTE NOT VERIFIED: DISCARD VOTE":
        discardedVotes += 1
    else:
        invalidVoteSub += 1

print('\n' + "Number of test Votes: %s" %len(testVotes))
print('\n' + "Votes Verified: %s /66" %verifiedVotes)
print("Votes Rejected: %s /66" %discardedVotes)
print("Invalid Votes(Vote x not 0 or 1): %s /33" %invalidVoteSub)
print('\n' + "Time elapsed by interactive protocol: %s" %(time.time() - timeStart))
